package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Calendar;
import java.util.Map;

//@Test
public class startDocker {
    public void start() throws Exception {
        boolean flag = false;
        Runtime
                .getRuntime()
                .exec(
                        "/usr/bin/open -a Terminal /Users/lavinaagrawal/TechProjects/dockerValidation/dockerup.sh");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,45);
        long stopnow = cal.getTimeInMillis();
        Thread.sleep(4000);

        while(System.currentTimeMillis()<stopnow) {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/lavinaagrawal/TechProjects/dockerValidation/output.txt"));
            String currentLine = reader.readLine();

            if(flag){
                break;
            }

            while (currentLine != null && !flag) {
                if (currentLine.contains("Registered a node")) {
                    System.out.println("found my text");
                    flag = true;
                    break;
                } else {
                    currentLine = reader.readLine();
                }
            }
            reader.close();
        }

            Assert.assertTrue(flag);

      /* Runtime
                .getRuntime()
                .exec(
                        "/usr/bin/open -a Terminal /Users/lavinaagrawal/TechProjects/dockerValidation/scale.sh");
            Thread.sleep(15000);*/
        }

    }

