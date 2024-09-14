package f_stage
import chisel3._

class Core extends Module{
    val io=IO (new Bundle{
    val inst=Input(UInt(32.W))
    val address=Output(UInt(32.W))
    })


    val fetch= Module(new Fetch)
    dontTouch(fetch.io)
    val decode= Module(new decode)
    dontTouch(decode.io)
    val execute= Module(new ALU)
    dontTouch(execute.io)
    val data_mem= Module(new DataMemory)
    dontTouch(data_mem.io)
    val w_back= Module(new WriteBack)
    dontTouch(w_back.io)
    // val reg_de= Module(new RegDE)
    // dontTouch(reg_de.io)
    // val reg_em= Module(new RegEM)
    // dontTouch(reg_em.io)
    // val reg_fd= Module(new RegFD)
    // dontTouch(reg_fd.io)
    // val reg_mw= Module(new RegMW)
    // dontTouch(reg_mw.io)
    
    //Fetch 
    fetch.io.imm:=decode.io.imm_out
    fetch.io.inst:=io.inst

    //Decode
    decode.io.inst:=io.inst

    //Execute
    execute.io.inst:=io.inst
    execute.io.arg_x:=decode.io.rs1_data
    execute.io.arg_y:=decode.io.rs2_data
    execute.io.imm:=decode.io.imm_out

    //Data Memory
    data_mem.io.inst:=io.inst
    data_mem.io.address:=

    //Write Back
    w_back.io.alu_data:=execute.io.alu_out
    w_back.io.mem_data:=data_mem.io.dout
    // w_back.io.load_en:=
    
}