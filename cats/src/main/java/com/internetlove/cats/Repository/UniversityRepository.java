package com.internetlove.cats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internetlove.cats.Entity.UniversityEntity;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity,Integer>{
	//UniversityEntity findByName(String name);
}
