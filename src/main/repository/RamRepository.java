package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.Ram;

public class RamRepository {
    public ArrayList<Ram> getAll(){
        ArrayList<Ram> listRam = new ArrayList<>();
        String sql = """
                     SELECT [id_Ram]
                           ,[MaRam]
                           ,[DungLuongRam]
                           ,[TrangThai]
                       FROM [dbo].[Ram]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ram ram = Ram.builder()
                        .IdRam(rs.getInt(1))
                        .MaRam(rs.getString(2))
                        .DungLuongRam(rs.getString(3))
                        .TrangThai(rs.getInt(4))
                        .build();
                listRam.add(ram);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listRam;
    }
}
