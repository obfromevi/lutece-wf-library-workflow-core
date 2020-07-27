/*
 * Copyright (c) 2002-2020, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.workflowcore.business.state;

import java.util.List;

/**
 *
 * IStateDAO
 *
 */
public interface IStateDAO
{
    /**
     * Insert a new record in the table.
     *
     * @param state
     *            instance of the State object to insert
     */
    void insert( State state );

    /**
     * update record in the table.
     *
     * @param state
     *            instance of the State object to update
     */
    void store( State state );

    /**
     * Load the state Object
     * 
     * @param nIdState
     *            the state id
     * @return the state Object
     */
    State load( int nIdState );

    /**
     * Load the state Object from the given resource
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @return the state Object
     */
    State findByResource( int nIdResource, String strResourceType, int nIdWorkflow );

    /**
     * Delete the state Object
     * 
     * @param nIdState
     *            the state id
     */
    void delete( int nIdState );

    /**
     * select all states by filter
     * 
     * @param filter
     *            StateFilter Object
     * @return a list of state
     */
    List<State> selectStatesByFilter( StateFilter filter );

    /**
     * return the maximum order number of that states in a given workflow
     * 
     * @param nWorkflowId
     *            the workflow id
     * @return the maximum order of the states in the workflow
     */
    int findMaximumOrderByWorkflowId( int nWorkflowId );

    /**
     * decrements the order of all the next states after the one which will be removed
     * 
     * @param nOrder
     *            the order
     * @param nIdWorkflow
     *            the workflow id
     */
    void decrementOrderByOne( int nOrder, int nIdWorkflow );

    /**
     * Finds all the states which have an order lower to a given order
     * 
     * @param nOrder1
     *            the order 1
     * @param nOrder2
     *            the order 2
     * @param nIdWorkflow
     *            the workflow id
     * @return List<State> the list of all the states
     */
    List<State> findStatesBetweenOrders( int nOrder1, int nOrder2, int nIdWorkflow );

    /**
     * Finds all the states which have an order greater to a given order
     * 
     * @param nOrder
     *            the order
     * @param nIdWorkflow
     *            the workflow id
     * @return List<State> the list of all the states
     */
    List<State> findStatesAfterOrder( int nOrder, int nIdWorkflow );

    /**
     * Finds all the states for the given workflow ordered by id
     * 
     * @param nIdWorkflow
     *            the workflow id
     * @return List<State> the list of all the states
     */
    List<State> findStatesForOrderInit( int nIdWorkflow );
}
