package com.example.savingsquadsfrontend.viewModel

import androidx.lifecycle.ViewModel
import com.example.savingsquadsfrontend.model.data.VoucherRedeem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class VoucherRedemptionViewModel : ViewModel() {

    private var _voucherRedemptionList = MutableStateFlow(
            listOf<VoucherRedeem>(
            VoucherRedeem("$5 Off", "100 Points"),
            VoucherRedeem("$10 Off", "200 Points"),
            VoucherRedeem("$20 Off", "400 points"),
            VoucherRedeem("$50 Off", "900 points"),
                )
    )

    val voucherRedemptionList = _voucherRedemptionList.asStateFlow()
}
