package com.wallet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.app.model.VendorBranch;

import java.util.List;

public interface VendorBranchRepository extends JpaRepository<VendorBranch, Long> {
    List<VendorBranch> findByVendorVendorId(Long vendorId);
}
