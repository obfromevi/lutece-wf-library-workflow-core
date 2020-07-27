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
package fr.paris.lutece.plugins.workflowcore.business.resource;

import java.util.List;
import java.util.Map;

/**
 *
 * IResourceWorkflowDAO
 *
 */
public interface IResourceWorkflowDAO
{
    /**
     * Insert a new record in the table.
     * 
     * @param resourceWorkflow
     *            instance of the ResourceWorkflow object to insert
     */
    void insert( ResourceWorkflow resourceWorkflow );

    /**
     * update record in the table.
     * 
     * @param resourceWorkflow
     *            instance of the ResourceWorkflow object to update
     */
    void store( ResourceWorkflow resourceWorkflow );

    /**
     * Load the Resource workflow Object
     * 
     * @param nIdResource
     *            the resource Id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @return the Document workflow Object
     */
    ResourceWorkflow load( int nIdResource, String strResourceType, int nIdWorkflow );

    /**
     * Delete resourceWorkflow Object
     * 
     * @param resourceWorkflow
     *            resourceWorkflow object
     */
    void delete( ResourceWorkflow resourceWorkflow );

    /**
     * Delete Workgroups list by list of id resource
     * 
     * @param listIdResource
     *            the resource list id
     * @param strResourceType
     *            the resource type
     * @param nIdWorflow
     *            the workflow id
     */
    void removeWorkgroupsByListIdResource( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow );

    /**
     * Delete resource list by list of id resource
     * 
     * @param listIdResource
     *            the resource list id
     * @param strResourceType
     *            the resource type
     * @param nIdWorflow
     *            the workflow id
     */
    void removeByListIdResource( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow );

    /**
     * Select All resourceWorkflow associated to the workflow
     * 
     * @param nIdWorkflow
     *            workflow id
     * @return List of resourceWorkflow Object
     */
    List<ResourceWorkflow> selectResourceWorkflowByWorkflow( int nIdWorkflow );

    /**
     * Select All resourceWorkflow associated to the workflow
     * 
     * @param nIdWorkflow
     *            workflow id
     * @return List of Id resource
     */
    List<Integer> selectResourceIdByWorkflow( int nIdWorkflow );

    /**
     * Select All resourceWorkflow associated to the state
     * 
     * @param nIdState
     *            workflow state
     * @return List of resourceWorkflow Object
     */
    List<ResourceWorkflow> selectResourceWorkflowByState( int nIdState );

    /**
     * select the resource entity owner
     * 
     * @param resourceWorkflow
     *            the resource
     * @return a list of entities Owner
     */
    List<String> selectWorkgroups( ResourceWorkflow resourceWorkflow );

    /**
     * delete all resource entities owner
     * 
     * @param resourceWorkflow
     *            the resource
     */
    void deleteWorkgroups( ResourceWorkflow resourceWorkflow );

    /**
     * insert a new entities owner
     * 
     * @param resourceWorkflow
     *            the resource
     * @param strWorkgroup
     *            the workgroupkey
     */
    void insertWorkgroup( ResourceWorkflow resourceWorkflow, String strWorkgroup );

    /**
     * Select ResourceWorkflow by filter
     * 
     * @param filter
     *            the ResourceWorkflow filter
     * @return ResourceWorkflow List
     */
    List<ResourceWorkflow> getListResourceWorkflowByFilter( ResourceWorkflowFilter filter );

    /**
     * Select ResourceWorkflow id by filter
     * 
     * @param filter
     *            the ResourceWorkflow filter
     * @return ResourceWorkflow id list
     */
    List<Integer> getListResourceWorkflowIdByFilter( ResourceWorkflowFilter filter );

    /**
     * Select ResourceWorkflow by filter
     * 
     * @param filter
     *            the ResourceWorkflow filter
     * @param lListIdWorkflowState
     *            the list of id workflow state
     * @return ResourceWorkflow List
     */
    List<Integer> getListResourceWorkflowIdByFilter( ResourceWorkflowFilter filter, List<Integer> lListIdWorkflowState );

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
