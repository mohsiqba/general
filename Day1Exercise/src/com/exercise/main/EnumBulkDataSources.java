package com.exercise.main;

public enum EnumBulkDataSources {
    EXCHANGE("ActiveSync", "V_CE_EXCHANGE_ACTIVESYNC", "cloudExtender.autoApproveBasedOnPolicy", "AS_REMOVE_DEV", "AS_APPROVE", "AS_BLOCK"),
    NOTES("Domino", "V_CE_LOTUS_TRAVELER", "cloudExtender.notesAutoApproveBasedOnPolicies", "TRAVELER_REMOVE", "TRAVELER_APPROVE", "TRAVELER_BLOCK"),
    GMAIL("GmailSync", "", "", "", "GS_APPROVE_DEV", "GS_BLOCK_DEV");

    private final String bulkDataSourceName;
    private final String ceModuleName;
    private final String cePolicyAttributeName;
    private final String removeActionName;
    private final String approveActionName;
    private final String blockActionName;

    public String getCePolicyAttributeName() {
        return cePolicyAttributeName;
    }

    public String getApproveActionName() {
        return approveActionName;
    }

    public String getRemoveActionName() {
        return removeActionName;
    }

    public String getCeModuleName() {
        return ceModuleName;
    }

    public String getBulkDataSourceName() {
        return bulkDataSourceName;
    }
    
    public String getBlockActionName()
    {
        return blockActionName;
    }

    EnumBulkDataSources(String bulkDataSourceName, String ceModuleName, String cePolicyAttributeName, String removeActionName, String approveActionName, String blockActionName) {
        this.bulkDataSourceName = bulkDataSourceName;
        this.ceModuleName = ceModuleName;
        this.cePolicyAttributeName = cePolicyAttributeName;
        this.removeActionName = removeActionName;
        this.approveActionName = approveActionName;
        this.blockActionName = blockActionName;
    }

}
