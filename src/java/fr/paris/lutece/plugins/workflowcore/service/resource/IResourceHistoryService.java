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

import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceHistory;

import java.util.List;

/**
 *
 * IResourceHistoryService
 *
 */
public interface IResourceHistoryService
{
    /**
     * Creation of an instance of resoureceHistory
     * 
     * @param resourceHistory
     *            The instance of resourceHistory which contains the informations to store
     */
    void create( ResourceHistory resourceHistory );

    /**
     * Remove resourceHistory which is specified in parameter
     * 
     * @param nIdHistory
     *            History id to remove
     */
    void remove( int nIdHistory );

    /**
     * Delete ResourceHistory list by list of id resource
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
     * Get list history id by list of id resource
     * 
     * @param listIdResource
     *            the resource list id
     * @param strResourceType
     *            the resource type
     * @param nIdWorflow
     *            the workflow id
     * @return list of history id
     */
    List<Integer> getListHistoryIdByListIdResourceId( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow );

    // Finders

    /**
     * Load the resource history Object
     * 
     * @param nIdHistory
     *            the resource history key
     * @return the resource workflow Object
     */
    ResourceHistory findByPrimaryKey( int nIdHistory );

    /**
     * Load all ResourceHistory Object for a given resource
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @return the list of ResourceHistory
     */
    List<ResourceHistory> getAllHistoryByResource( int nIdResource, String strResourceType, int nIdWorkflow );

    /**
     * Load all ResourceHistory Object for a given resource
     * 
     * @param nIdAction
     *            the action id
     * @return the list of ResourceHistory
     */
    List<ResourceHistory> getAllHistoryByAction( int nIdAction );

    /**
     * Load the last resource history depending creation date
     * 
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdWorkflow
     *            the workflow id
     * @return the list of ResourceHistory
     */
    ResourceHistory getLastHistoryResource( int nIdResource, String strResourceType, int nIdWorkflow );
}
