package com.example.Movie.Repository;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.Movie.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	Optional<Rating> save(Optional<Rating> ratting);

	List<Rating> findByCID(String cid);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Rating R set R.Ratingcus=:Ratingcus where R.CID=:CID")
	void updateById(@Param("CID") String Cid,@Param("Ratingcus") float rate);
	

}
