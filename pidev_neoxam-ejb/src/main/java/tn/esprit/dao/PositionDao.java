package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Position;

public interface PositionDao {
	
	public List<Position> allPositions();

	public Position singlePosition(int id);

	public Position savePosition(Position position);

	public Position updatePosition(Position position) throws Exception;

	public void deletePosition(int id) throws Exception;
	
	public List<Employee> getEmployeesByPosition(Position position);

}
