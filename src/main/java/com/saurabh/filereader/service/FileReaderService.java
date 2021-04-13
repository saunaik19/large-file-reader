package com.saurabh.filereader.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileReaderService {

    public static void main(String[] args) {
        FileReaderService fileReaderService=new FileReaderService();
                fileReaderService.execute();
    }

    String sourceFilepath = "D:\\MyCodeBase\\SampleDataForTesting\\wikibooks";
    private List<Path> filePaths=new ArrayList<>();
    public void execute(){
      //  listDownFiles(sourceFilepath);
        listDownFilesUsingStream();
        System.out.println("Total no of files "+filePaths.size());
        filePaths.forEach(file->{
            System.out.println("File path is "+file.toString());
            readCurentFile(file);

        });
    }

    private void readCurentFile(Path file) {
        try {
            System.out.println("File path ::::"+file.toString());
            Files.lines(file).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void listDownFiles(String sourceFilepath) {
           File sourceFolder = new File(sourceFilepath);
           for(File file:sourceFolder.listFiles()){
               if (file.isDirectory()){
                   listDownFiles(file.toString());}
               else{
               System.out.println(file.getName());
               }
           }
           //one more method
    }

    private void listDownFilesUsingStream(){
        System.out.println("Using stream...");
        try (Stream<Path> paths = Files.walk(Paths.get(sourceFilepath))) {
            paths.filter(Files::isRegularFile)
                    .map(filePath-> filePaths.add(filePath))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
