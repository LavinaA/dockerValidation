package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;

public class stopDocker {

    //@Test
    public void stopDocker() throws Exception {
        boolean flag = false;
        Runtime
                .getRuntime()
                .exec(
                        "/usr/bin/open -a Terminal /Users/lavinaagrawal/TechProjects/dockerValidation/dockerDown.sh");

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
                if (currentLine.contains("selenium-hub exited")) {
                    System.out.println("Docker stopped successfully");
                    flag = true;
                    break;
                } else {
                    currentLine = reader.readLine();
                }
            }
            reader.close();
        }

            Assert.assertTrue(flag);

        }

    }

