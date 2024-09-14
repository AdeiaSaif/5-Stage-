package f_stage
import chisel3._
import chisel3.util._

class decode extends Module{
    var io=IO(new Bundle{
        val ins=Input(UInt(32.W))
       
        val imm_out=Output(SInt(32.W))
        val ins_out=Output(UInt(32.W))
        val rs1_data=Output(SInt(32.W))
        val rs2_data=Output(SInt(32.W))

    })
    
    val cu = Module(new control_unit)
    dontTouch(cu.io)
    val imm = Module(new imm)
    dontTouch(imm.io)
    val reg_file = Module(new RegFile)
    dontTouch(reg_file.io)


    //IO
    io.imm_out:=imm.io.out
    io.ins_out:=io.ins
    io.rs1_data:=reg_file.io.out1
    io.rs2_data:=reg_file.io.out2

    //control unit
    cu.io.ins:=io.ins

    //imm
    imm.io.ins:=io.ins

    //Register File
    reg_file.io.rs1:=cu.io.rs1
    reg_file.io.rs2:=cu.io.rs2
    reg_file.io.rd:=cu.io.rd
    reg_file.io.w_en:=cu.io.writereg
    reg_file.io.data:=imm.io.out

}