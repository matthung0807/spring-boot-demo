package com.abc.demo.repository;

import com.abc.demo.entity.ModifyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifyLogRepository extends JpaRepository<ModifyLog, Long> {
}
