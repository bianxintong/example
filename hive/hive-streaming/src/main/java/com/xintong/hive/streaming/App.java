package com.xintong.hive.streaming;

import java.util.ArrayList;

import org.apache.hive.hcatalog.streaming.DelimitedInputWriter;
import org.apache.hive.hcatalog.streaming.HiveEndPoint;
import org.apache.hive.hcatalog.streaming.StreamingConnection;
import org.apache.hive.hcatalog.streaming.TransactionBatch;

public class App {
	public static void main(String[] args) throws Exception {
		// ------- MAIN THREAD ------- //
		String dbName = "xintong";
		String tblName = "streaming";
		String[] fieldNames = new String[] { "id", "msg" };
		ArrayList<String> partitionVals = new ArrayList<String>(2);
		partitionVals.add("Asia");
		partitionVals.add("India");
		String serdeClass = "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe";

		HiveEndPoint hiveEP = new HiveEndPoint("thrift://hadoop145107:9083", dbName, tblName, partitionVals);
		System.out.println(hiveEP);
		// ------- Thread 1 -------//
		StreamingConnection connection = hiveEP.newConnection(true);
		System.out.println("connected");
		DelimitedInputWriter writer = new DelimitedInputWriter(fieldNames, ",", hiveEP);
		TransactionBatch txnBatch = connection.fetchTransactionBatch(10, writer);

		///// Batch 1 - First TXN
		txnBatch.beginNextTransaction();
		txnBatch.write("1,Hello streaming".getBytes());
		txnBatch.write("2,Welcome to streaming".getBytes());
		txnBatch.commit();

		if (txnBatch.remainingTransactions() > 0) {
			///// Batch 1 - Second TXN
			txnBatch.beginNextTransaction();
			txnBatch.write("3,Roshan Naik".getBytes());
			txnBatch.write("4,Alan Gates".getBytes());
			txnBatch.write("5,Owen O¡¯Malley".getBytes());
			txnBatch.commit();

			txnBatch.close();
			connection.close();
		}
	}
}
