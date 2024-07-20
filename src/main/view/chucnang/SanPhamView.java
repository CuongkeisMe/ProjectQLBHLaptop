package main.view.chucnang;

import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import main.entity.Cpu;
import main.entity.Gpu;
import main.entity.ManHinh;
import main.entity.OCung;
import main.entity.Pin;
import main.entity.Ram;
import main.repository.CpuRepository;
import main.repository.GpuRepository;
import main.repository.ManHinhRepository;
import main.repository.OCungRepository;
import main.repository.PinRepository;
import main.repository.RamRepository;
import main.view.sanphamchitiet.CpuView;
import main.view.sanphamchitiet.GpuView;
import main.view.sanphamchitiet.ManHinhView;
import main.view.sanphamchitiet.OCungView;
import main.view.sanphamchitiet.PinView;
import main.view.sanphamchitiet.RamView;

public class SanPhamView extends javax.swing.JInternalFrame {
    private DefaultComboBoxModel cpuDcbm;
    private DefaultComboBoxModel gpuDcbm;
    private DefaultComboBoxModel ramDcbm;
    private DefaultComboBoxModel manhinhDcbm;
    private DefaultComboBoxModel pinDcbm;
    private DefaultComboBoxModel ocungDcbm;
    
    private CpuRepository cpuRepository;
    private GpuRepository gpuRepository;
    private RamRepository ramRepository;
    private ManHinhRepository manhinhRepository;
    private PinRepository pinRepository;
    private OCungRepository ocungRepository;
    
    private void showComboboxCPU(){
        cpuDcbm.removeAllElements();
        for(Cpu cpu : cpuRepository.getAll()){
            cpuDcbm.addElement(cpu.getTenCPU());
        }
    }
    
    private void showComboboxGPU(){
        gpuDcbm.removeAllElements();
        for(Gpu gpu : gpuRepository.getAll()){
            gpuDcbm.addElement(gpu.getTenGPU());
        }
    }
    
    private void showComboboxRam(){
        ramDcbm.removeAllElements();
        for(Ram ram : ramRepository.getAll()){
            ramDcbm.addElement(ram.getDungLuongRam());
        }
    }
    
    private void showComboboxManHinh(){
        manhinhDcbm.removeAllElements();
        for(ManHinh mh : manhinhRepository.getAll()){
            manhinhDcbm.addElement(mh.getKichThuoc());
        }
    }
    
    private void showComboboxPin(){
        pinDcbm.removeAllElements();
        for(Pin pin : pinRepository.getAll()){
            pinDcbm.addElement(pin.getDungLuongPin());
        }
    }
    
    private void showComboboxOCung(){
        ocungDcbm.removeAllElements();
        for(OCung oc : ocungRepository.getAll()){
            ocungDcbm.addElement(oc.getLoaiOCung());
        }
    }
    
    public SanPhamView() {
        initComponents();
        this.cauhinhForm();
        this.cboDinhDang();
        this.repositoryDinhDang();
        this.showComboboxCPU();
        this.showComboboxGPU();
        this.showComboboxManHinh();
        this.showComboboxOCung();
        this.showComboboxPin();
        this.showComboboxRam();
    }

    public void cauhinhForm(){
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
    
    private void cboDinhDang(){
        cpuDcbm = (DefaultComboBoxModel) cboCPU.getModel();
        gpuDcbm = (DefaultComboBoxModel) cboGPU.getModel();
        ramDcbm = (DefaultComboBoxModel) cboRam.getModel();
        manhinhDcbm = (DefaultComboBoxModel) cboKichThuoc.getModel();
        pinDcbm = (DefaultComboBoxModel) cboPin.getModel();
        ocungDcbm = (DefaultComboBoxModel) cboOCung.getModel();
    }
    
    private void repositoryDinhDang(){
        cpuRepository = new CpuRepository();
        gpuRepository = new GpuRepository();
        ramRepository = new RamRepository();
        manhinhRepository = new ManHinhRepository();
        pinRepository = new PinRepository();
        ocungRepository = new OCungRepository();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLySP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaNhap1 = new javax.swing.JTextField();
        txtGiaNhap2 = new javax.swing.JTextField();
        cboImei = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cboCPU = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnAddCPU = new javax.swing.JButton();
        cboRam = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnAddRam = new javax.swing.JButton();
        cboGPU = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnAddGPU = new javax.swing.JButton();
        cboPin = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnAddPin = new javax.swing.JButton();
        cboOCung = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnAddOCung = new javax.swing.JButton();
        cboKichThuoc = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnAddKichThuoc = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setMaximizable(true);
        setFrameIcon(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Lọc giá");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("->");

        tblQuanLySP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Hình ảnh", "CPU", "GPU", "Loại ổ cứng", "Ram", "Kích thước", "Pin", "Số lượng", "Giá nhập", "Giá xuất"
            }
        ));
        jScrollPane1.setViewportView(tblQuanLySP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Chọn hình ảnh");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên SP");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Imei");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giá nhập");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Giá bán");

        txtGiaNhap1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaNhap1.setText("VNĐ");
        txtGiaNhap1.setBorder(null);

        txtGiaNhap2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaNhap2.setText("VNĐ");
        txtGiaNhap2.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaNhap)
                            .addComponent(cboImei, 0, 154, Short.MAX_VALUE))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSP))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(14, 14, 14)
                        .addComponent(txtGiaBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhap2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thuộc Tính", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.add(cboCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("CPU");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 40, -1));

        btnAddCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAddCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCPUMouseClicked(evt);
            }
        });
        btnAddCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCPUActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 30));

        cboRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRamActionPerformed(evt);
            }
        });
        jPanel3.add(cboRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 140, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("RAM");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        btnAddRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAddRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRamActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 140, 30));

        jPanel3.add(cboGPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("GPU");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        btnAddGPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAddGPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGPUActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddGPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 30));

        jPanel3.add(cboPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 140, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("PIN");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        btnAddPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAddPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPinActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 140, -1));

        cboOCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOCungActionPerformed(evt);
            }
        });
        jPanel3.add(cboOCung, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 140, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Ổ CỨNG");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        btnAddOCung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAddOCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOCungActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddOCung, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 140, 30));

        cboKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKichThuocActionPerformed(evt);
            }
        });
        jPanel3.add(cboKichThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 140, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("KÍCH THƯỚC");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        btnAddKichThuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAddKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKichThuocActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddKichThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 140, 30));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/32378_add_plus_icon.png"))); // NOI18N
        btnAdd.setText("Thêm");
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 90, 50));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/1582587_arrow_refresh_reload_rotate icon_icon.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 90, 50));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/11211468_eraser_clear_remove_tool_rubber_icon.png"))); // NOI18N
        btnClear.setText("Clear");
        jPanel3.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 90, 50));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/icon/5049209_bin_delete_remove_trash_icon.png"))); // NOI18N
        btnDelete.setText("Xóa");
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRamActionPerformed

    private void cboOCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOCungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboOCungActionPerformed

    private void cboKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboKichThuocActionPerformed

    private void btnAddCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCPUMouseClicked
        
    }//GEN-LAST:event_btnAddCPUMouseClicked

    private void btnAddCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCPUActionPerformed
        CpuView cpu = new CpuView();
        cpu.setVisible(true);
    }//GEN-LAST:event_btnAddCPUActionPerformed

    private void btnAddGPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGPUActionPerformed
        GpuView gpu = new GpuView();
        gpu.setVisible(true);
    }//GEN-LAST:event_btnAddGPUActionPerformed

    private void btnAddRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRamActionPerformed
        RamView ram = new RamView();
        ram.setVisible(true);
    }//GEN-LAST:event_btnAddRamActionPerformed

    private void btnAddOCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOCungActionPerformed
        OCungView oc = new OCungView();
        oc.setVisible(true);
    }//GEN-LAST:event_btnAddOCungActionPerformed

    private void btnAddKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKichThuocActionPerformed
        ManHinhView mh = new ManHinhView();
        mh.setVisible(true);
    }//GEN-LAST:event_btnAddKichThuocActionPerformed

    private void btnAddPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPinActionPerformed
        PinView p = new PinView();
        p.setVisible(true);
    }//GEN-LAST:event_btnAddPinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCPU;
    private javax.swing.JButton btnAddGPU;
    private javax.swing.JButton btnAddKichThuoc;
    private javax.swing.JButton btnAddOCung;
    private javax.swing.JButton btnAddPin;
    private javax.swing.JButton btnAddRam;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCPU;
    private javax.swing.JComboBox<String> cboGPU;
    private javax.swing.JComboBox<String> cboImei;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboOCung;
    private javax.swing.JComboBox<String> cboPin;
    private javax.swing.JComboBox<String> cboRam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblQuanLySP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtGiaNhap1;
    private javax.swing.JTextField txtGiaNhap2;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
