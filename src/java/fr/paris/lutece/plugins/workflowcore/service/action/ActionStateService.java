package fr.paris.lutece.plugins.workflowcore.service.action;

import java.util.List;
import javax.inject.Inject;

import fr.paris.lutece.plugins.workflowcore.business.action.IActionStateDAO;

public class ActionStateService implements IActionStateService {
	
	@Inject
	private IActionStateDAO _actionStateDAO;
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void create( int idAction, List<Integer> listIdStateBefore )
    {
    	_actionStateDAO.insert( idAction, listIdStateBefore );
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public void update( int idAction, List<Integer> listIdStateBefore ) {
		_actionStateDAO.delete( idAction );
		create( idAction, listIdStateBefore );		
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public void remove(int nIdAction) {
		_actionStateDAO.delete( nIdAction );
		
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public List<Integer> findByIdAction(int nIdAction) {
		return _actionStateDAO.load( nIdAction ) ;
	}
	
	

}
