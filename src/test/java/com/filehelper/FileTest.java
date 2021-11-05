package com.filehelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author prog_evil
 * @Date 2021/11/5 1:12 上午
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {


    @Test
    public void contextLoads() {
    }


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Logger logger = LoggerFactory.getLogger(FileTest.class);

    //create mvc environment
    @Before
    public void create() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

   /*
    * @Author ProG_Evil
    * @Description //test interface of upload
    * @Date 1:17 上午 2021/11/5
    * @Param []
    * @return void
    **/
    @Test
    public void uploadFile() {
        try {
            String result = mockMvc.perform(
                            MockMvcRequestBuilders
                                    //send request url
                                    .fileUpload("/file/upload")

                                    .file(
                                            new MockMultipartFile("file", "test.txt", ",multipart/form-data", "hello upload".getBytes("UTF-8"))
                                    )
                    ).andExpect(status().isOk())
                    //return response
                    .andReturn().getResponse().getContentAsString();
            logger.debug("create file");
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * @Author ProG_Evil
     * @Description //test interface of download
     * @Date 1:17 上午 2021/11/5
     * @Param []
     * @return void
     **/
    @Test
    public void downLoadFile() throws Exception {
        mockMvc.perform(
                        /*
                         * @Author ProG_Evil
                         * @Description //download file
                         * @Date 1:16 上午 2021/11/5
                         * @Param []
                         * @return void
                         **/
                        MockMvcRequestBuilders
                                .get("/file/download")
                                .param("uuid", "5e7b3a9754c2777f96174d4ccb980d23")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andDo(new ResultHandler() {
                           @Override
                           public void handle(MvcResult mvcResult) throws Exception {

                               File file = new File("/downloadFile/");
                               file.delete();

                               FileOutputStream fout = new FileOutputStream(file);
                               //return the success stream
                               ByteArrayInputStream bin = new ByteArrayInputStream(mvcResult.getResponse().getContentAsByteArray());
                               //copy files
                               StreamUtils.copy(bin, fout);
                               //close the stream
                               fout.close();
                               logger.info("is exist:" + file.exists());
                               logger.info("file length:" + file.length());
                           }
                       }
                );
    }

    /*
     * @Author ProG_Evil
     * @Description //get the info of files
     * @Date 1:23 上午 2021/11/5
     * @Param []
     * @return void
     **/
    @Test
    public void getFileInfo(){
        try {
            String result = mockMvc.perform(
                            MockMvcRequestBuilders
                                    //send get info
                                    .get("/file/getFileInfo")

                                    .param("uuid",
                                            "5e7b3a9754c2777f96174d4ccb980d23"
                                    )
                    ).andExpect(status().isOk())
                    //return response
                    .andReturn().getResponse().getContentAsString();
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

