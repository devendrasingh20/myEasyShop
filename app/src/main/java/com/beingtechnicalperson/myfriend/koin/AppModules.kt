package com.beingtechnicalperson.myfriend.koin


import com.beingtechnicalperson.myfriend.fragment.*
import org.koin.dsl.module


//val profileCreationVMlModule = module {
//    viewModel{ ProfileCreationActivityVM() }
//}

val userVMModule = module {
    //    viewModel { UserViewModel(get()) }
//    viewModel { HomeFragmentViewModel() }
//    viewModel { EditProfileViewModel() }

}
val fragmentModule = module {
        factory { SignUpFragment() }
        factory { LoginFragment() }
        factory { NameFragment() }
        factory { PersonDetailsFragment() }
        factory { InterestFragment() }
//    factory { MyProfileViewFragment() }
}
val apiRepository = module {
    //    single { ApiRepository() }
}