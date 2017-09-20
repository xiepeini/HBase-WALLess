/**
 *
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
package org.apache.hadoop.hbase.regionserver.memstore.replication;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.hadoop.hbase.classification.InterfaceAudience;
import org.apache.hadoop.hbase.regionserver.memstore.replication.v2.RegionReplicaReplicator;
import org.apache.hadoop.hbase.shaded.protobuf.generated.MemstoreReplicaProtos.ReplicateMemstoreRequest;
import org.apache.hadoop.hbase.shaded.protobuf.generated.MemstoreReplicaProtos.ReplicateMemstoreResponse;

@InterfaceAudience.Private
public interface MemstoreReplicator {
  ReplicateMemstoreResponse replicate(MemstoreReplicationKey memstoreReplicationKey,
      MemstoreEdits memstoreEdits, RegionReplicaReplicator regionReplicaReplicator)
      throws IOException, InterruptedException, ExecutionException;

  // TODO : Use this in  replica regions
  ReplicateMemstoreResponse replicate(ReplicateMemstoreRequest request,
      RegionReplicaReplicator regionReplicaReplicator)
      throws IOException, InterruptedException, ExecutionException;

  public int getNextReplicationThread();
}
