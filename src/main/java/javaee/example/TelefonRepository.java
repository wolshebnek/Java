package javaee.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javaee.example.domain.Telefon;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TelefonRepository {

    List<Telefon> telefons;
    public static final String PATHNAME = "D:/Univer/eclips/telefon-security1/jsons/telefon.json";

    public TelefonRepository(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            telefons = mapper.readValue(new File(PATHNAME), new TypeReference<List<Telefon>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            telefons = new ArrayList<>();
        }
    }

    public List<Telefon> findAll(){
        return telefons;
    }

    // delete by id
    public void delete(int id){
        for (int i = 0; i < telefons.size(); i++) {
            if(id == telefons.get(i).getId()){
                telefons.remove(i);
                break;
            }
        }
        updateJsonFile();
    }

    public void save(Telefon telefon){
        if(telefon.getId() != 0) {
            for (int i = 0; i < telefons.size(); i++) {
                if(telefon.getId() == telefons.get(i).getId()){
                    telefons.set(i, telefon);
                    break;
                }
            }
        }else{
            telefon.setId(telefons.size() + 1);
            telefons.add(telefon);
        }
        updateJsonFile();
    }

    public Telefon findTelefonById(int id){
        for(Telefon telefon:findAll()){
            if(telefon.getId() == id){
                return telefon;
            }
        }
        return new Telefon();
    }

    private void updateJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(PATHNAME), telefons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
