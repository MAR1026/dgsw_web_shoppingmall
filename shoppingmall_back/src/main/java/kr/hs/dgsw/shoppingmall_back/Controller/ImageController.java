package kr.hs.dgsw.shoppingmall_back.Controller;


import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @GetMapping(value = "/download/{filename}")
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String filename) {
        try {
            String filepath = "C:\\Users\\User\\IdeaProjects\\shoppingmall\\img\\" + filename;
            File file = new File(filepath);
            if(file.exists() == false) return;

            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType ="application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Desposition", "inline; filename=\""

            + filename + "\"");

            response.setContentLength((int) file.length());
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(is, response.getOutputStream());
        }catch(Exception ex){
            System.out.println(ex.getMessage());

        }
    }
}
