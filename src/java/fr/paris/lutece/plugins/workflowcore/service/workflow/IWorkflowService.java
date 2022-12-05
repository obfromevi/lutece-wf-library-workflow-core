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
package fr.paris.lutece.plugins.workflowcore.service.workflow;

import fr.paris.lutece.api.user.User;
import fr.paris.lutece.plugins.workflowcore.business.action.Action;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceWorkflow;
import fr.paris.lutece.plugins.workflowcore.business.state.State;
import fr.paris.lutece.plugins.workflowcore.business.workflow.Workflow;
import fr.paris.lutece.plugins.workflowcore.business.workflow.WorkflowFilter;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * WorkflowService
 */
public interface IWorkflowService
{
    /**
     * Creation of an instance of workflow
     * 
     * @param workflow
     *            The instance of workflow which contains the informations to store
     */
    void create( Workflow workflow );

    /**
     * Update of workflow which is specified in parameter
     * 
     * @param workflow
     *            The instance of workflow which contains the informations to update
     */
    void update( Workflow workflow );

    /**
     * Remove workflow which is specified in parameter
     * 
     * @param nIdWorkflow
     *            the workflow to remove
     */
    void remove( int nIdWorkflow );

    // FINDERS

    /**
     * Load the workflow Object
     * 
     * @param nIdWorkflow
     *            the workflow id
     * @return the Workflow Object
     */
    Workflow findByPrimaryKey( int nIdWorkflow );

    /**
     * return the workflow list by filter
     * 
     * @param filter
     *            the filter
     * @return the workflow list
     */
    List<Workflow> getListWorkflowsByFilter( WorkflowFilter filter );

    /**
     * returns a list of actions possible for a given resource based on the status of the resource in the workflow, the user role and if the prerequisites are
     * satisfied.
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @return a list of Action
     */
    Collection<Action> getActions( int nIdResource, String strResourceType, int nIdWorkflow );

    /**
     * returns a list of actions possible for a given resource based on the status of the resource in the workflow and the user role
     * 
     * @param listIdResource
     *            the list of resource id
     * @param strResourceType
     *            the resource type
     * @param nIdExternalParentId
     *            the external parent identifier
     * @param nIdWorkflow
     *            the workflow id
     * @return a list of Action
     */
    Map<Integer, List<Action>> getActions( List<Integer> listIdResource, String strResourceType, Integer nIdExternalParentId, int nIdWorkflow );

    /**
     * returns the state of a given resource
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @param nIdExternalParentId
     *            the external parent id
     * @return the state of a given resource
     */
    State getState( int nIdResource, String strResourceType, int nIdWorkflow, Integer nIdExternalParentId );

    /**
     * returns all state of a given workflow
     * 
     * @param nIdWorkflow
     *            the workflow id
     * @return the list of states of a given workflow
     */
    Collection<State> getAllStateByWorkflow( int nIdWorkflow );

    /**
     * Get the list of mass actions from a given id workflow
     * 
     * @param nIdWorkflow
     *            the id workflow
     * @return a list of actions
     */
    List<Action> getMassActions( int nIdWorkflow );

    /**
     * Get the list of mass actions following a state from a given id workflow
     * 
     * @param nIdWorkflow
     *            the workflow id
     * @param stateId
     *            the state id
     * @return the mass actions
     */
    List<Action> getMassActions( int nIdWorkflow, int stateId );

    /**
     * Return a map which contains the task types
     * 
     * @param locale
     *            the locale
     * @return a reference list which contains the task types
     */
    Map<String, String> getMapTaskTypes( Locale locale );

    /**
     * Create a ResourceWorkflow Object wich contains the association of resource and the initial state of the workflow
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param workflow
     *            the workflow
     * @param nExternalParentId
     *            the id external parent
     * @return a ResourceWorkflow Object
     */
    ResourceWorkflow getInitialResourceWorkflow( int nIdResource, String strResourceType, Workflow workflow, Integer nExternalParentId );

    // CHECK

    /**
     * Return true if a form is associate to the action
     * 
     * @param nIdAction
     *            the action id
     * @param locale
     *            the loacle
     * @return true if a form is associate to the action
     */
    boolean isDisplayTasksForm( int nIdAction, Locale locale );

    /**
     * Check if the action can be proceed for the given resource
     * 
     * @param nIdResource
     *            the id resource
     * @param strResourceType
     *            the resource type
     * @param nIdAction
     *            the id action
     * @param nExternalParentId
     *            the external parent id
     * @return true if the action can proceed, false otherwise
     */
    boolean canProcessAction( int nIdResource, String strResourceType, int nIdAction, Integer nExternalParentId );

    // DO

    /**
     * Proceed action given in parameter
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdAction
     *            the action id
     * @param nExternalParentId
     *            the external parent id*
     * @param request
     *            the request
     * @param locale
     *            locale
     * @param bIsAutomatic
     *            true if action is automatic
     * @param strUserAccessCode
     *            the user access code
     * @deprecated use {@link IWorkflowService#doProcessAction(int, String, int, Integer, HttpServletRequest, Locale, boolean, String, User)}
     */
    @Deprecated
    void doProcessAction( int nIdResource, String strResourceType, int nIdAction, Integer nExternalParentId, HttpServletRequest request, Locale locale,
            boolean bIsAutomatic, String strUserAccessCode );

    /**
     * Proceed action given in parameter
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdAction
     *            the action id
     * @param nExternalParentId
     *            the external parent id*
     * @param request
     *            the request
     * @param locale
     *            locale
     * @param bIsAutomatic
     *            true if action is automatic
     * @param strUserAccessCode
     *            the user access code
     * @param the
     *            user the user
     */
    default void doProcessAction( int nIdResource, String strResourceType, int nIdAction, Integer nExternalParentId, HttpServletRequest request, Locale locale,
            boolean bIsAutomatic, String strUserAccessCode, User user )
    {
        doProcessAction( nIdResource, strResourceType, nIdAction, nExternalParentId, request, locale, bIsAutomatic, strUserAccessCode );
    }

    /**
     * Proceed automatic reflexive actions of state given in parameter
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdState
     *            the state id
     * @param nIdExternalParent
     *            the external parent id*
     * @param locale
     *            locale
     * @deprecated use {@link IWorkflowService#doProcessAutomaticReflexiveActions(int, String, int, Integer, Locale, User)
     */
    @Deprecated
    void doProcessAutomaticReflexiveActions( int nIdResource, String strResourceType, int nIdState, Integer nIdExternalParent, Locale locale );

    /**
     * Proceed automatic reflexive actions of state given in parameter
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdState
     *            the state id
     * @param nIdExternalParent
     *            the external parent id*
     * @param locale
     *            locale
     * @param user
     *            the user
     */
    default void doProcessAutomaticReflexiveActions( int nIdResource, String strResourceType, int nIdState, Integer nIdExternalParent, Locale locale,
            User user )
    {
        doProcessAutomaticReflexiveActions( nIdResource, strResourceType, nIdState, nIdExternalParent, locale );
    }

    /**
     * Remove in every workflows the resource specified in parameter
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     */
    void doRemoveWorkFlowResource( int nIdResource, String strResourceType );

    /**
     * Remove list of resource by list of id resource
     * 
     * @param lListIdResource
     *            the list of resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorflow
     *            the workflow id
     */
    void doRemoveWorkFlowResourceByListId( List<Integer> lListIdResource, String strResourceType, Integer nIdWorflow );

    /**
     * Get the list of ids of resources of a given type that are in a given state
     * 
     * @param nIdState
     *            The id of the state of resources to get
     * @param strResourceType
     *            The type of resources to get
     * @return The list of resources matching both given state id and resource given. Return an empty list if no resource was found, or if the state does not
     *         exist.
     */
    List<Integer> getResourceIdListByIdState( int nIdState, String strResourceType );

    /**
     * Execute action automatic
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @param nExternalParentId
     *            the external parent id
     * @deprecated use {@link IWorkflowService#executeActionAutomatic(int, String, int, Integer, User)
     */
    @Deprecated
    void executeActionAutomatic( int nIdResource, String strResourceType, int nIdWorkflow, Integer nExternalParentId );

    /**
     * Execute action automatic
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @param nExternalParentId
     *            the external parent id
     * 
     * @param user
     *            the user
     */
    default void executeActionAutomatic( int nIdResource, String strResourceType, int nIdWorkflow, Integer nExternalParentId, User user )
    {
        executeActionAutomatic( nIdResource, strResourceType, nIdWorkflow, nExternalParentId );
    }

    /**
     * Check if an automatic action can be processed or not
     * 
     * @param nIdResource
     *            The id of the resource
     * @param strResourceType
     *            The resource type
     * @param nIdAction
     *            The id of the action
     * @return True if the action can be processed, false otherwise
     */
    boolean canAutomaticActionBeProcessed( int nIdResource, String strResourceType, int nIdAction );

	/**
	 * {@inheritDoc}
	 */
	List<Integer> getResourceIdListByIdState(int nIdState, String strResourceType, int nExternalParentId);
}
