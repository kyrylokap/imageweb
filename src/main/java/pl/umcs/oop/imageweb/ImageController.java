package pl.umcs.oop.imageweb;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
public class ImageController {
    @PostMapping("/restapi/image/adjust-brightness")
    public ResponseEntity<String> adjustBrigthness(@RequestBody ImageDTO imageDTO) throws IOException {
        String image64 = imageDTO.base64Image;
        String [] image= image64.split(",");
        String imageType = image[0].substring(image[0].indexOf("/") + 1,
                           image[0].indexOf(";") + 1);
        byte[] imageByte = Base64.getDecoder().decode(image[1]);
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(new ByteArrayInputStream(imageByte));



        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
