package ie.cit.group3.repository;

import ie.cit.group3.entity.GameType;

import org.springframework.data.repository.CrudRepository;


public interface GameTypeRepository extends CrudRepository<GameType, Integer> {
	//CrudRepository gives us access to inherited methods like save, findAll, delete etc & Convention over coding.

	public GameType findByGamename(String gamename);

//	public GameType get(int game_id, String gamename, int gamepoints);


}
