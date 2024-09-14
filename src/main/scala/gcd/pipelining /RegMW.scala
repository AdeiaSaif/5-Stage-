package f_stage
import chisel3._

class RegMW extends Module{
    val io=IO(new Bundle{
        val alu_data=Input(SInt(32.W))
        val mem_data=Input(SInt(32.W))
        val imm=Input(SInt(32.W))
        val load_en=Input(Bool()) 

        val alu_data_out=Output(SInt(32.W))
        val mem_data_out=Output(SInt(32.W))
        val imm_out=Output(SInt(32.W))
        val load_en_out=Output(Bool())
    })
    
    val alu_data =RegInit(0.S(32.W))
    val mem_data =RegInit(0.S(32.W))
    val imm =RegInit(0.S(32.W))
    val load_en =RegInit(0.B)

    alu_data:=io.alu_data
    mem_data:=io.mem_data
    imm:=io.imm
    load_en:=io.load_en

    io.alu_data_out:=alu_data
    io.imm_out:=imm
    io.mem_data_out:=mem_data
    io.load_en_out:=load_en

}