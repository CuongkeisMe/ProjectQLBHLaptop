package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.OCung;

public class OCungRepository {
    public ArrayList<OCung> getAll(){
        ArrayList<OCung> listOCung = new ArrayList<>();
        String sql = """
                     SELECT [id_OCung]
                           ,[MaOCung]
                           ,[LoaiOCung]
                           ,[TrangThai]
                       FROM [dbo].[OCung]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                OCung oc = OCung.builder()
                        .IdOCung(rs.getInt(1))
                        .MaOCung(rs.getString(2))
                        .LoaiOCung(rs.getString(3))
                        .TrangThai(rs.getInt(4))
                        .build();
                listOCung.add(oc);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listOCung;
    }
}
