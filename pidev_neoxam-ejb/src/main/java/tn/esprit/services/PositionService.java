package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Position;

@Local
public interface PositionService {
	public List<Position> allPositions();

	public Position singlePosition(int id);

	public Position savePosition(Position position);

	public Position updatePosition(Position position) throws Exception;

	public void deletePosition(int id) throws Exception;
	
	public List<Employee> getEmployeesByPosition(Position position);

}
