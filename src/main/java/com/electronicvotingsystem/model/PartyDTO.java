package com.electronicvotingsystem.model;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
	public class PartyDTO 
	{

		private int partyId;

		@NotNull
		private String partyName;

		@NotNull
		private String leader;

		@NotNull
		private String symbol;
		
		

		public PartyDTO() {
			super();
		}

		public PartyDTO(int partyId, @NotNull String partyName, @NotNull String leader, @NotNull String symbol) {
			super();
			this.partyId = partyId;
			this.partyName = partyName;
			this.leader = leader;
			this.symbol = symbol;
		}

		public int getPartyId() {
			return partyId;
		}

		public void setPartyId(int partyId) {
			this.partyId = partyId;
		}

		public String getPartyName() {
			return partyName;
		}

		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}

		public String getLeader() {
			return leader;
		}

		public void setLeader(String leader) {
			this.leader = leader;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return "Party [partyId=" + partyId + ", partyName=" + partyName + ", leader=" + leader + ", symbol="
					+ symbol + "]";
		}
	

	}
