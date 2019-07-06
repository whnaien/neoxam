package tn.esprit.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.impl.PositionDaoImpl;
import tn.esprit.entities.Position;
import tn.esprit.services.PositionService;

@Stateless
@LocalBean
public class PositionServiceImpl implements PositionService{
		

		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		
		@EJB
		PositionDaoImpl positionDaoImp;
		
	

		@Override
		public List<Position> allPositions() {
			// TODO Auto-generated method stub
			return positionDaoImp.allPositions();
		}

		@Override
		public Position singlePosition(int id) {
			return positionDaoImp.singlePosition(id);
		}

		@Override
		public Position savePosition(Position position) {
			// TODO Auto-generated method stub
			return positionDaoImp.savePosition(position);
		}

		@Override
		public Position updatePosition(Position position) throws Exception {
			// TODO Auto-generated method stub
			return positionDaoImp.updatePosition(position);
		}

		@Override
		public void deletePosition(int id) throws Exception {
			positionDaoImp.deletePosition(id);
			
		}

	}
	
