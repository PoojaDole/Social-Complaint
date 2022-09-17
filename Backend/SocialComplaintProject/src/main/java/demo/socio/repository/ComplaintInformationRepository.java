package demo.socio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.socio.entity.ComplaintInformationEntity;

@Repository
public interface ComplaintInformationRepository extends JpaRepository<ComplaintInformationEntity, Long> {

}
