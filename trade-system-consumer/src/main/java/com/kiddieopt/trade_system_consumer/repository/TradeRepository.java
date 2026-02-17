package com.kiddieopt.trade_system_consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiddieopt.trade_system_consumer.entity.TradeEntity;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Long> {
}
