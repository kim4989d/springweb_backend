package com.base.webapp.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.webapp.common.tray.ResultSetTray;
import com.base.webapp.common.tray.Tray;
import com.base.webapp.dao.BoardDao;
import com.base.webapp.dao.CrawLingDao;

public class CrawCommandCmd extends CommandFactory {
	private static final Logger logger = LoggerFactory.getLogger(BoardCmd.class);

	public CrawCommandCmd() {
		logger.info(this.getClass().getName());

	}

	@Override
	public ResultSetTray execute(Tray reqTray, HttpServletRequest request, HttpServletResponse response) {
		final Logger logger = LoggerFactory.getLogger(BoardCmd.class);

		logger.info("do execute 실행 .");

		ResultSetTray rsTray = null;
		ResultSetTray checkoptiontray = null;

		try {
			CrawLingDao dao = new CrawLingDao();
			rsTray = dao.CrawLingList(getConnection(), reqTray);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			request.setAttribute("rsTray", rsTray);
		}

		// TODO Auto-generated method stub
		return rsTray;
	}

}
