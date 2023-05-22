package top.joww.game.dao;

import top.joww.game.entity.VeriCode;

public interface VeriCodeDao {
	String checkVeriCode(VeriCode vc);
	String getVeriCode(VeriCode vc);
	String setVeriCode(VeriCode vc);
}
