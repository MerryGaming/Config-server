package org.example;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Value("${spring.datasource.driver-class-name:Data Null}")
  private String Name;

  @Value("${spring.datasource.username:Data Null}")
  private String Username;

  @Value("${spring.datasource.password:Data Null}")
  private String Password;

  @Value("${message1:Data Null}")
  private String message1;

  @Value("${message2:Data Null}")
  private String message2;

  @RequestMapping("/info")
  Object getMessage() {
    Map<String, String> data = new HashMap<String, String>();
    data.put("spring.datasource.driver-class-name", Name);
    data.put("spring.datasource.username", Username);
    data.put("spring.datasource.password", Password);
    data.put("message1", message1);
    data.put("message2", message2);

    return data;
  }
}
