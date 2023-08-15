package luis.jwt.security.ejemplo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    /**
     * Maneja una solicitud POST en el punto final "/demo".
     *
     * @return Un mensaje de bienvenida desde el punto final seguro.
     */
    @PostMapping(value = "demo")
    public String welcome(){
        return "welcome from secure endpoint";
    }

}
