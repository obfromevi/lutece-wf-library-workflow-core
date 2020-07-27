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
package fr.paris.lutece.plugins.workflowcore.service.resource;

import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceWorkflow;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceWorkflowFilter;

import java.util.List;
import java.util.Map;

/**
 *
 * IResourceWorkflowService
 *
 */
public interface IResourceWorkflowService
{
    /**
     * Creation of an instance of resoureceWorkflow
     * 
     * @param resourceWorkflow
     *            The instance of resourceWorkflow which contains the informations to store
     */
    void create( ResourceWorkflow resourceWorkflow );

    /**
     * Update of resourceWorkflow which is specified in parameter
     * 
     * @param resourceWorkflow
     *            The instance of resourceWorkflow which contains the informations to update
     */
    void update( ResourceWorkflow resourceWorkflow );

    /**
     * Remove resourceWorkflow which is specified in parameter
     * 
     * @param resourceWorkflow
     *            The instance of resourceWorkflow which contains the informations to remove
     */
    void remove( ResourceWorkflow resourceWorkflow );

    /**
     * Delete record and workflow list by list id resource
     * 
     * @param listIdResource
     *            list of resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorflow
     *            the worflow id
     */
    void removeByListIdResource( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow );

    // Finders

    /**
     * Load the resourceWorkflow Object
     * 
     * @param nIdResource
     *            the resource Id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @return the resource workflow Object
     */
    ResourceWorkflow findByPrimaryKey( int nIdResource, String strResourceType, int nIdWorkflow );

    /**
     * Select All resourceWorkflow Object associated to the workflow
     * 
     * @param nIdWorkflow
     *            workflow id
     * @return List of resourceWorkflow Object
     */
    List<ResourceWorkflow> getAllResourceWorkflowByWorkflow( int nIdWorkflow );

    /**
     * Select All resourceWorkflow Object associated to the workflow
     * 
     * @param nIdWorkflow
     *            workflow id
     * @return List of Id resource
     */
    List<Integer> getAllResourceIdByWorkflow( int nIdWorkflow );

    /**
     * Select All resourceWorkflow Object associated to the state
     * 
     * @param nIdState
     *            state
     * @return List of resourceWorkflow Object
     */
    List<ResourceWorkflow> getAllResourceWorkflowByState( int nIdState );

    /**
     * Select ResourceWorkflow by filter
     * 
     * @param resourceWorkflowFilter
     *            the filter
     * @return ResourceWorkflow List
     */
    List<ResourceWorkflow> getListResourceWorkflowByFilter( ResourceWorkflowFilter resourceWorkflowFilter );

    /**
     * Select Resource Workflow id by filter
     * 
     * @param resourceWorkflowFilter
     *            the filter
     * @param lListIdWorkflowState
     *            list of workflow state
     * @return ResourceWorkflow list id
     */
    List<Integer> getListResourceIdWorkflowByFilter( ResourceWorkflowFilter resourceWorkflowFilter, List<Integer> lListIdWorkflowState );

    /**
     * Select ResourceWorkflow ID by filter
     * 
     * @param resourceWorkflowFilter
     *            the filter
     * @return ResourceWorkflow ID List
     */
    List<Integer> getListResourceIdWorkflowByFilter( ResourceWorkflowFilter resourceWorkflowFilter );

    /**
     * Select id state by list id resource
     * 
     * @param lListIdResource
     *            the resource list id
     * @param nIdWorflow
     *            The worflow id
     * @param strResourceType
     *            the ressource type
     * @param nIdExternalParentId
     *            the external parent id
     * @return a map of <id_resource, id_state>
     */
    Map<Integer, Integer> getListIdStateByListId( List<Integer> lListIdResource, int nIdWorflow, String strResourceType, Integer nIdExternalParentId );
}
