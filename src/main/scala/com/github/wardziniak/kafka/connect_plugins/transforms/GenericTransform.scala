package com.github.wardziniak.kafka.connect_plugins.transforms

import org.apache.kafka.connect.connector.ConnectRecord
import org.apache.kafka.connect.data.Schema
import org.apache.kafka.connect.transforms.Transformation

trait GenericTransform[R <: ConnectRecord[R]] extends Transformation[R]{

  protected def operatingSchema(record: R): Schema

  protected def operatingValue(record: R): Any

  protected def newRecord(record: R, updatedSchema: Schema, updatedValue: Any): R

}

trait ValueGenericTransform[R <: ConnectRecord[R]] extends GenericTransform[R]{
  override protected def operatingSchema(record: R): Schema = record.valueSchema()

  override protected def operatingValue(record: R): AnyRef = record.value()

  override protected def newRecord(record: R, updatedSchema: Schema, updatedValue: Any): R = {
    record.newRecord(record.topic, record.kafkaPartition, record.keySchema(), record.key(), updatedSchema, updatedValue, record.timestamp)
  }
}

trait KeyGenericTransform[R <: ConnectRecord[R]] extends GenericTransform[R]{
  override protected def operatingSchema(record: R): Schema = record.keySchema()

  override protected def operatingValue(record: R): AnyRef = record.key()

  override protected def newRecord(record: R, updatedSchema: Schema, updatedValue: Any): R = {
    record.newRecord(record.topic, record.kafkaPartition, updatedSchema, updatedValue, record.valueSchema, record.value, record.timestamp)
  }
}