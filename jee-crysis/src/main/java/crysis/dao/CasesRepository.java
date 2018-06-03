package crysis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import crysis.entities.cases.Case;

public interface CasesRepository extends JpaRepository<Case, Long>{

}
