package f_stage
import chisel3._
import chisel3.util._

class control_unit extends Module{
    var io=IO(new Bundle{
        val ins=Input(UInt(32.W))
        val rs1=Output(UInt(5.W))
        val rs2=Output(UInt(5.W))
        val rd=Output(UInt(5.W))
        val func3=Output(UInt(3.W))
        val ins_out=Output(UInt(32.W))
        val writereg=Output(Bool())
    })
    
    io.ins_out:=io.ins
    io.rd:=io.ins(11,7)
    io.rs1:=io.ins(19,15)
    io.rs2:=io.ins(24,20)
    io.func3:=Mux(io.ins(6,0)==="b0110011".U,Cat(io.ins(30),io.ins(14,12)),io.ins(14,12))
    io.writereg:=Mux((io.ins(6,0)==="b0110011".U)|| ( io.ins(6,0)==="b0010011".U)||(io.ins(6,0)==="b0000011".U) || (io.ins(6,0)==="b0110111".U) ||(io.ins(6,0)==="b1101111".U)|| (io.ins(6,0)==="b0010111".U) ,1.B,0.B)
}