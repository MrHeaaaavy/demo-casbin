package com.mrheaaaavy.demo.casbin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.casbin.jcasbin.main.Enforcer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoCasbinApplicationTests {

  private final Enforcer enforcer;

  @Autowired
  DemoCasbinApplicationTests(Enforcer enforcer) {
    this.enforcer = enforcer;
  }

  @Test
  void testEnforcerLoaded() {
    assertTrue(enforcer.enforce("bob", "domain2", "/shop", "GET"));
    assertTrue(enforcer.enforce("bob", "domain2", "/shop", "POST"));

    assertTrue(enforcer.enforce("alice", "domain2", "/shop", "POST"));
    assertTrue(enforcer.enforce("alice", "domain2", "/shop", "GET"));

    assertTrue(enforcer.enforce("alice", "domain1", "/merchant", "POST"));
    assertTrue(enforcer.enforce("alice", "domain1", "/merchant", "GET"));
  }

}
