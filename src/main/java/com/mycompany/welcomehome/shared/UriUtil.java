package com.mycompany.welcomehome.shared;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class UriUtil {
    public static URI buildUriWithId(String path, Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
