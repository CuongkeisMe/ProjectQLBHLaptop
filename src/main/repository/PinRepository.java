package main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.config.DBConnect;
import main.entity.Pin;

public class PinRepository {
    public ArrayList<Pin> getAll(){
        ArrayList<Pin> listPin = new ArrayList<>();
        String sql = """
                     SELECT [id_Pin]
                           ,[MaPin]
                           ,[DungLuongPin]
                           ,[TrangThai]
                       FROM [dbo].[Pin]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pin pin = Pin.builder()
                        .IdPin(rs.getInt(1))
                        .MaPin(rs.getString(2))
                        .DungLuongPin(rs.getString(3))
                        .TrangThai(rs.getInt(4))
                        .build();
                listPin.add(pin);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listPin;
    }
}
