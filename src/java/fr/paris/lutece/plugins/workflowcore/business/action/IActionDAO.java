/*
 * Copyright (c) 2002-2021, City of Paris
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
package fr.paris.lutece.plugins.workflowcore.business.action;

import java.util.Collection;
import java.util.List;

/**
 * IActionDAO
 **/
public interface IActionDAO
{
    /**
     * Insert a new record in the table.
     *
     * @param action
     *            instance of the Action object to insert
     */
    void insert( Action action );

    /**
     * update record in the table.
     *
     * @param action
     *            instance of the Action object to update
     */
    void store( Action action );

    /**
     * Load the action Object
     * 
     * @param nIdAction
     *            the state id
     * @return the Action Object
     */
    Action load( int nIdAction );

    /**
     * Load the action Object with icon associated
     * 
     * @param nIdAction
     *            the state id
     * @return the Action Object
     */
    Action loadWithIcon( int nIdAction );

    /**
     * Delete the action Object
     * 
     * @param nIdAction
     *            the action id
     */
    void delete( int nIdAction );

    /**
     * select all actions by filter
     * 
     * @param filter
     *            the action filter
     * @return a list of action
     */
    List<Action> selectActionsByFilter( ActionFilter filter );

    /**
     * Create the links between actions
     * 
     * @param nIdAction
     *            the id action
     * @param nIdLinkedAction
     *            the id linked action
     */
    void insertLinkedActions( int nIdAction, int nIdLinkedAction );

    /**
     * Remove the links between actions
     * 
     * @param nIdAction
     *            the ID action
     */
    void removeLinkedActions( int nIdAction );

    /**
     * Load the list of IDs linked to the given ID action.
     * 
     * @param nIdAction
     *            the ID action
     * @return a list of IDs
     */
    Collection<Integer> selectListIdsLinkedAction( int nIdAction );

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
     * Finds all the actions which have an order lower to a given order
     * 
     * @deprecated
     * This method will be replaced by method {@link #findActionsBetweenOrders(int, int, int))
     *
     * @param nOrder1
     *            the order 1
     * @param nOrder2
     *            the order 2
     * @param nIdWorkflow
     *            the workflow id
     * @return List<Action> the list of all the actions
     */
     @Deprecated
     List<Action> findStatesBetweenOrders( int nOrder1, int nOrder2, int nIdWorkflow );
     
     /**
      * Finds all the actions which have an order lower to a given order
      * 
      * @param nOrder1
      *            the order 1
      * @param nOrder2
      *            the order 2
      * @param nIdWorkflow
      *            the workflow id
      * @return List<Action> the list of all the actions
      */
      
      default List<Action> findActionsBetweenOrders( int nOrder1, int nOrder2, int nIdWorkflow ){
    	  
    	  return findStatesBetweenOrders( nOrder1, nOrder2, nIdWorkflow );
      }

    /**
     * Finds all the actions which have an order greater to a given order
     * 
     * @deprecated
     * This method will be replaced by method {@link #findActionsAfterOrder(int, int)}
     * 
     * @param nOrder
     *            the order
     * @param nIdWorkflow
     *            the workflow id
     * @return List<Action> the list of all the actions.
     */
     @Deprecated
     List<Action> findStatesAfterOrder( int nOrder, int nIdWorkflow );
     
     /**
      * Finds all the actions which have an order greater to a given order
      * 
      * @param nOrder
      *            the order
      * @param nIdWorkflow
      *            the workflow id
      * @return List<Action> the list of all the actions.
      */
      default List<Action> findActionsAfterOrder( int nOrder, int nIdWorkflow ){
    	 
    	  return findStatesAfterOrder( nOrder, nIdWorkflow );
      }

    /**
     * Finds all the actions for the given workflow ordered by id
     * 
     * @param nIdWorkflow
     *            the workflow id
     * @return List<Action> the list actions. Only regular actions are returned, automatic reflexive actions are ignored.
     */
    List<Action> findActionsForOrderInit( int nIdWorkflow );
}
