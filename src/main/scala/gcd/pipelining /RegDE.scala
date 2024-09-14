package f_stage
import chisel3._


class RegDE extends Module{
    val io =IO(new Bundle{
        val data_1=Input(SInt(32.W))
        val data_2=Input(SInt(32.W))
        val imm=Input(SInt(32.W))
        val inst=Input(UInt(32.W))

        val data_1_out=Output(SInt(32.W))
        val data_2_out=Output(SInt(32.W))
        val imm_out=Output(SInt(32.W))
        val inst_out=Output(UInt(32.W))
    })
    

    val data_1 =RegInit(0.S(32.W))
    val data_2 =RegInit(0.S(32.W))
    val imm =RegInit(0.S(32.W))
    val inst =RegInit(0.U(32.W))

    data_1:=io.data_1
    data_2:=io.data_2
    imm:=io.imm
    inst:=io.inst

    io.data_1_out:=data_1
    io.data_2_out:=data_2
    io.imm_out:=imm
    io.inst_out:=inst
}