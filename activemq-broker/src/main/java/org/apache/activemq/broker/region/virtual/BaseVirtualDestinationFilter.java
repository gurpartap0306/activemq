/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.broker.region.virtual;

import org.apache.activemq.broker.region.BaseDestination;
import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.broker.region.DestinationFilter;

public class BaseVirtualDestinationFilter extends DestinationFilter {
    
    public BaseVirtualDestinationFilter(Destination next) {
        super(next);
    }

    BaseDestination getBaseDestination(Destination virtualDest) {
        if (virtualDest instanceof BaseDestination) {
            return (BaseDestination) virtualDest;
        } else if (virtualDest instanceof DestinationFilter) {
            return ((DestinationFilter) virtualDest).getAdaptor(BaseDestination.class);
        }
        return null;
    }
}
