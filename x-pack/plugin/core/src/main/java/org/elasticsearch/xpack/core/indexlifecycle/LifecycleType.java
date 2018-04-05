/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.core.indexlifecycle;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.io.stream.NamedWriteable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface LifecycleType extends NamedWriteable {

    /**
     * @return the first phase of this policy to execute
     */
    List<Phase> getOrderedPhases(Map<String, Phase> phases);

    List<LifecycleAction> getOrderedActions(Phase phase);


    /**
     * validates whether the specified <code>phases</code> are valid for this
     * policy instance.
     * 
     * @param phases
     *            the phases to verify validity against
     * @throws IllegalArgumentException
     *             if a specific phase or lack of a specific phase is invalid.
     */
    void validate(Collection<Phase> phases);

    /**
     * Each {@link LifecyclePolicy} has a specific type to differentiate
     * themselves. Every implementation is responsible to providing its specific
     * type.
     * 
     * @return the {@link LifecyclePolicy} type.
     */
    String getType();
}