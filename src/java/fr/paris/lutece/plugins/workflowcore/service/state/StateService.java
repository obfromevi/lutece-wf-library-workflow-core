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
package fr.paris.lutece.plugins.workflowcore.service.state;

import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceWorkflow;
import fr.paris.lutece.plugins.workflowcore.business.state.IStateDAO;
import fr.paris.lutece.plugins.workflowcore.business.state.State;
import fr.paris.lutece.plugins.workflowcore.business.state.StateFilter;
import fr.paris.lutece.plugins.workflowcore.service.resource.IResourceWorkflowService;

import java.util.List;

import javax.inject.Inject;

/**
 *
 * StateService
 *
 */
public class StateService implements IStateService
{
    public static final String BEAN_SERVICE = "workflow.stateService";
    @Inject
    private IStateDAO _stateDAO;
    @Inject
    private IResourceWorkflowService _resourceWorkflowService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create( State state )
    {
        _stateDAO.insert( state );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update( State state )
    {
        _stateDAO.store( state );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove( int nIdState )
    {
        State state = findByPrimaryKey( nIdState );

        if ( state != null )
        {
            // remove workflow resources associated
            List<ResourceWorkflow> listResourceWorkflow = _resourceWorkflowService.getAllResourceWorkflowByState( nIdState );

            for ( ResourceWorkflow resourceWorkflow : listResourceWorkflow )
            {
                _resourceWorkflowService.remove( resourceWorkflow );
            }
        }

        _stateDAO.delete( nIdState );
    }

    // FINDERS

    /**
     * {@inheritDoc}
     */
    @Override
    public State findByPrimaryKey( int nIdState )
    {
        return _stateDAO.load( nIdState );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State findByResource( int nIdResource, String strResourceType, int nIdWorkflow )
    {
        return _stateDAO.findByResource( nIdResource, strResourceType, nIdWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<State> getListStateByFilter( StateFilter filter )
    {
        return _stateDAO.selectStatesByFilter( filter );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State getInitialState( int nIdWorkflow )
    {
        // test if initial test already exist
        StateFilter filter = new StateFilter( );
        filter.setIdWorkflow( nIdWorkflow );
        filter.setIsInitialState( StateFilter.FILTER_TRUE );

        List<State> listState = getListStateByFilter( filter );

        if ( listState.size( ) != 0 )
        {
            return listState.get( 0 );
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int findMaximumOrderByWorkflowId( int nWorkflowId )
    {
        return _stateDAO.findMaximumOrderByWorkflowId( nWorkflowId );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decrementOrderByOne( int nOrder, int nIdWorkflow )
    {
        _stateDAO.decrementOrderByOne( nOrder, nIdWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<State> findStatesBetweenOrders( int nOrder1, int nOrder2, int nIdWorkflow )
    {
        return _stateDAO.findStatesBetweenOrders( nOrder1, nOrder2, nIdWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<State> findStatesAfterOrder( int nOrder, int nIdWorkflow )
    {
        return _stateDAO.findStatesAfterOrder( nOrder, nIdWorkflow );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeStateOrder( int nIdWorkflow )
    {
        List<State> listState = _stateDAO.findStatesForOrderInit( nIdWorkflow );
        int nOrder = 1;

        for ( State state : listState )
        {
            state.setOrder( nOrder );
            update( state );
            nOrder++;
        }
    }
}
