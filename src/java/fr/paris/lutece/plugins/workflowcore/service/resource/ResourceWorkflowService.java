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

import fr.paris.lutece.plugins.workflowcore.business.resource.IResourceWorkflowDAO;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceWorkflow;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceWorkflowFilter;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

/**
 *
 * ResourceWorkflowService
 */
public class ResourceWorkflowService implements IResourceWorkflowService
{
    public static final String BEAN_SERVICE = "workflow.resourceWorkflowService";
    @Inject
    private IResourceWorkflowDAO _resourceWorkflowDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create( ResourceWorkflow resourceWorkflow )
    {
        List<String> listWorkgroup = resourceWorkflow.getWorkgroups( );
        resourceWorkflow.setAssociatedWithWorkgroup( CollectionUtils.isNotEmpty( listWorkgroup ) );

        _resourceWorkflowDAO.insert( resourceWorkflow );

        if ( listWorkgroup != null )
        {
            for ( String workgroup : listWorkgroup )
            {
                _resourceWorkflowDAO.insertWorkgroup( resourceWorkflow, workgroup );
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update( ResourceWorkflow resourceWorkflow )
    {
        List<String> listWorkgroup = resourceWorkflow.getWorkgroups( );
        resourceWorkflow.setAssociatedWithWorkgroup( CollectionUtils.isNotEmpty( listWorkgroup ) );
        _resourceWorkflowDAO.store( resourceWorkflow );
        // update workgroups list
        _resourceWorkflowDAO.deleteWorkgroups( resourceWorkflow );

        if ( listWorkgroup != null )
        {
            for ( String workgroup : listWorkgroup )
            {
                _resourceWorkflowDAO.insertWorkgroup( resourceWorkflow, workgroup );
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove( ResourceWorkflow resourceWorkflow )
    {
        _resourceWorkflowDAO.deleteWorkgroups( resourceWorkflow );
        _resourceWorkflowDAO.delete( resourceWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeByListIdResource( List<Integer> listIdResource, String strResourceType, Integer nIdWorflow )
    {
        _resourceWorkflowDAO.removeWorkgroupsByListIdResource( listIdResource, strResourceType, nIdWorflow );
        _resourceWorkflowDAO.removeByListIdResource( listIdResource, strResourceType, nIdWorflow );
    }

    // FINDERS

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceWorkflow findByPrimaryKey( int nIdResource, String strResourceType, int nIdWorkflow )
    {
        ResourceWorkflow resourceWorkflow = _resourceWorkflowDAO.load( nIdResource, strResourceType, nIdWorkflow );

        if ( resourceWorkflow != null )
        {
            resourceWorkflow.setWorkgroups( _resourceWorkflowDAO.selectWorkgroups( resourceWorkflow ) );
        }

        return resourceWorkflow;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResourceWorkflow> getAllResourceWorkflowByWorkflow( int nIdWorkflow )
    {
        return _resourceWorkflowDAO.selectResourceWorkflowByWorkflow( nIdWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getAllResourceIdByWorkflow( int nIdWorkflow )
    {
        return _resourceWorkflowDAO.selectResourceIdByWorkflow( nIdWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResourceWorkflow> getAllResourceWorkflowByState( int nIdState )
    {
        return _resourceWorkflowDAO.selectResourceWorkflowByState( nIdState );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResourceWorkflow> getListResourceWorkflowByFilter( ResourceWorkflowFilter resourceWorkflowFilter )
    {
        return _resourceWorkflowDAO.getListResourceWorkflowByFilter( resourceWorkflowFilter );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getListResourceIdWorkflowByFilter( ResourceWorkflowFilter resourceWorkflowFilter, List<Integer> lListIdWorkflowState )
    {
        return _resourceWorkflowDAO.getListResourceWorkflowIdByFilter( resourceWorkflowFilter, lListIdWorkflowState );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getListResourceIdWorkflowByFilter( ResourceWorkflowFilter resourceWorkflowFilter )
    {
        return _resourceWorkflowDAO.getListResourceWorkflowIdByFilter( resourceWorkflowFilter );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Integer, Integer> getListIdStateByListId( List<Integer> lListIdRessource, int nIdWorflow, String strResourceType, Integer nIdExternalParentId )
    {
        return _resourceWorkflowDAO.getListIdStateByListId( lListIdRessource, nIdWorflow, strResourceType, nIdExternalParentId );
    }
}
