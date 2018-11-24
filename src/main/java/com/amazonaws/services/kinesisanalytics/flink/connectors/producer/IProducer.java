/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amazonaws.services.kinesisanalytics.flink.connectors.producer;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * Interface responsible for sending data a specific sink
 */
public interface IProducer<O, R> {

    /**
     * This method should send data to an specific destination.
     * @param record the type of data to be sent
     * @return a {@code ListenableFuture} with the result for the operation.
     * @throws Exception
     */
    ListenableFuture<O> addUserRecord(final R record) throws Exception;

    /**
     * This method should send data to an specific destination
     * @param record the type of data to be sent
     * @param operationTimeoutInMillis the expected operation timeout
     * @return a {@code ListenableFuture} with the result for the operation.
     * @throws Exception
     */
    ListenableFuture<O> addUserRecord(final R record, final long operationTimeoutInMillis) throws Exception;

    /**
     * Destroy and release any used resource.
     * @throws Exception
     */
    void destroy() throws Exception;

    /**
     * Returns whether the producer has been destroyed or not
     * @return
     */
    boolean isDestroyed();

    /**
     * Should return the number of outstanding records if the producer implements buffering.
     * @return an integer with the number of outstanding records.
     */
    int getOutstandingRecordsCount();
}